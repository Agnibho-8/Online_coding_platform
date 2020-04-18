package com.example.FinalYearProject.Online.Coding.Platform.web;

import ModelResponse.UserSubmissionResponse;
import com.example.FinalYearProject.Online.Coding.Platform.domain.Problems;
import com.example.FinalYearProject.Online.Coding.Platform.service.ProblemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProblemsController {
    @Autowired
    ProblemsService service;

    @GetMapping("/problems")
    public ResponseEntity<List<Problems>> getAllProblems() {
        return new ResponseEntity<List<Problems>>(service.findAll(),HttpStatus.OK);
    }

    @GetMapping(path = "/problems/{id}")
    public ResponseEntity<Optional<Problems>> findProblemById(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }

    @PostMapping(path = "/problems/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> getSubmission(@RequestBody UserSubmissionResponse userSubmissionResponse, @PathVariable("id") int id) throws IOException {
        // Make a file tempid.lang to store the code submitted by user
        String filename = "temp";
        filename += "." +userSubmissionResponse.getLanguage();
        File ansfile = new File("C:\\Users\\ASUS\\IdeaProjects\\Online-Coding-Platform\\UserAnswers\\"+filename);
        FileWriter write = new FileWriter(ansfile);
        write.write(userSubmissionResponse.getAnswer());
        write.write(System.lineSeparator());
        write.flush();
        write.close();

        // make a batch file to run that code
        File batfile = new File("C:\\Users\\ASUS\\IdeaProjects\\Online-Coding-Platform\\BatchFiles\\BatchFile.bat");
        FileWriter writer = new FileWriter(batfile);
        writer.write("@ echo off");
        writer.write(System.lineSeparator());
        if (userSubmissionResponse.getLanguage().equalsIgnoreCase("java")) {
            writer.write("javac temp.java");
            writer.write(System.lineSeparator());
            writer.write("java Solution < input" + id + ".txt");
            writer.write(System.lineSeparator());
        }
        //TODO add 2 else if for C and python
        writer.write("pause");
        writer.flush();
        writer.close();

        //Use processBuilder to run that batch file code and get the output
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "BatchFile.bat");
        processBuilder.directory(new File("C:\\Users\\ASUS\\IdeaProjects\\Online-Coding-Platform\\BatchFiles"));
            Process process = processBuilder.start();
            // blocked :(
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            List<String> userOutput =null;
            while ((line = reader.readLine()) != null) {
                userOutput.add(line);
            }


        //Read the outfile
        File output = new File("C:\\Users\\ASUS\\IdeaProjects\\Online-Coding-Platform\\BatchFiles\\BatchFile.bat");
        BufferedReader read = new BufferedReader(new FileReader(output));
        List<String> expectedOutput = null;
        String l;
        while ((l = read.readLine()) != null) {
            expectedOutput.add(l);
        }

        //check if two lists are same
        if(expectedOutput.equals(userOutput)){
                return new ResponseEntity<>("Congratulations!",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Wrong!",HttpStatus.OK);
        }
    }
}
