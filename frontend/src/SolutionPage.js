import React,{Component} from 'react';
import logo from './logo.svg';
import './App.css';
import Axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Image,Container,Dropdown,Button,Form} from 'react-bootstrap'
import style from 'styled-components'

const Header=style.div`
width:100%;
border-bottom:#bf0000 3px solid;
text-align:center;`


const DropdownMenu=style(Dropdown)`
padding:0px 30px 0px 0px;

`

const FormInput=style(Form)`
padding:30px 30px 0px 0px;
`
 class solutionPage extends Component {
  constructor(props){
     super(props);
     this.state={
      language:"",
       postrequestdata:[],
       code:""
       

     }
  }
//   componentDidMount(){
//     Axios.post(`http://localhost:8080/users/searchbydate?date=2020-12-10${this.state.name}`).then(
//       response=>{
//         const UserDetails=response.data;
        
//           this.setState({
//             details:UserDetails
//           })
        
//       }
//     );
    
//   }
  handleInput=(event)=>{
    this.setState({

      code:event.target.value
     
    })
    
  }
  buttonClick=()=>{
    console.log("hERE");
    var solution={
      "language":this.state.language,
      "answer":this.state.code
    }
    console.log(solution)
    Axios.post(`http://localhost:8080/problems/1`,solution)
    .then(responce=>{console.log(responce)})
    .catch(error=>console.log(error))
  }


  handleClick=(event)=>{
    console.log(event)
    var option="Java"
    if(event==="1")
   
    option="Python"
    else if(event==="2")
    {
    option="C"}
   

    this.setState({

      language:option
     
    })


  }
   render(){
    return (
      <div>
      <img src="./header.jpg" width="100%" height="100px"></img> 
      <Container>
     
        <p style={{padding:"100px 0 10px 0", margin:"0px"}}><strong>Select Language</strong></p>
        <DropdownMenu>
        <Dropdown.Toggle variant="primary" id="dropdown-basic" >
         {this.state.language.length!==0?this.state.language:"Language Dropdown"} 
        </Dropdown.Toggle>
   
        <Dropdown.Menu>
          <Dropdown.Item eventKey="1" onSelect={this.handleClick}>Pyhton</Dropdown.Item>
          <Dropdown.Item eventKey="2" onSelect={this.handleClick}>C</Dropdown.Item>
          <Dropdown.Item eventKey="3" onSelect={this.handleClick}>Java</Dropdown.Item>
        </Dropdown.Menu>
      </DropdownMenu>

      <FormInput>
  <Form.Group controlId="formBasicEmail">
    <Form.Label><strong>Start Coding:</strong></Form.Label>
    <Form.Control type="text" as="textarea" onChange={this.handleInput} style={{border:"2px #bf0000 solid",height:"600px"}}/>
    
  </Form.Group>
  </FormInput>
  <Button variant="primary" size="lg" disabled={this.state.language.length!=0&&this.state.code.length!=0?false:true} onClick={this.buttonClick} block>
    Submit
  </Button>
 
    </Container>
    </div>
     );
      
 
}
 }
export default solutionPage;
