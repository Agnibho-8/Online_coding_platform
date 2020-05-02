package com.example.FinalYearProject.Online.Coding.Platform.web;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.FinalYearProject.Online.Coding.Platform.ModelResponse.UserSubmissionRequest;
import com.example.FinalYearProject.Online.Coding.Platform.domain.Problems;
import com.example.FinalYearProject.Online.Coding.Platform.service.ProblemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
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

    @PostMapping(path = "/problems/{id}")
    public ResponseEntity<String> getSubmission(@RequestBody UserSubmissionRequest userSubmissionRequest, @PathVariable("id") int id) throws IOException {
        // Make a file tempid.lang to store the code submitted by user
                String filename = "Solution";
                filename += "." + userSubmissionRequest.getLanguage();
                String filePath = new File(".").getCanonicalPath();
                File ansfile = new File(filePath + "/BatchFiles/" + filename);
                FileWriter write = new FileWriter(ansfile, false);
                write.write(userSubmissionRequest.getAnswer());
                write.write(System.lineSeparator());
                write.flush();
                write.close();
                // make a batch file to run that code
                File batfile = new File(filePath + "/BatchFiles/BatchFile.bat");
                FileWriter writer = new FileWriter(batfile);
                writer.write("@ echo off");
                writer.write(System.lineSeparator());
                if (userSubmissionRequest.getLanguage().equalsIgnoreCase("java")) {
                    writer.write("javac Solution.java");
                    writer.write(System.lineSeparator());
                    writer.write("java Solution < input" + id + ".txt");
                    writer.write(System.lineSeparator());
                }
                //TODO add 2 else if for C and python
                writer.flush();
                writer.close();

                //Use processBuilder to run that batch file code and get the output
                ProcessBuilder processBuilder = new ProcessBuilder();
                processBuilder.command("cmd.exe", "/c", "BatchFile.bat");
                processBuilder.directory(new File(filePath + "/BatchFiles"));
                Process process = processBuilder.start();
                System.out.println("process:  "+process.toString());
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;
                List<String> userOutput = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    System.out.println("userOutput:   "+line);
                    userOutput.add(line);
                }
        //Read the outfile
        File output = new File(filePath+"/BatchFiles/expectedOutput"+id+".txt");
        BufferedReader read = new BufferedReader(new FileReader(output));
        List<String> expectedOutput = new ArrayList<String>();
        String l;
        while ((l = read.readLine()) != null) {
            System.out.println("expected output:   "+l);
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
