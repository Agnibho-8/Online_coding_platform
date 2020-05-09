import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import axios from 'axios';
import Login from './Login';

class Register extends Component {
  constructor(props){
    super(props);
    this.state={
      username:'',
      firstName:'',
      lastName:'',
      email:'',
      password:''
    }
    this.handleClick = this.handleClick.bind(this)
  }
  componentWillReceiveProps(nextProps){
    console.log("nextProps",nextProps);
  }
  handleClick(event){
    console.log("Event ----:"+event,event.target.value)
    var apiBaseUrl = "http://localhost:8080";
    // console.log("values in register handler",role);
    var self = this;
    //To be done:check for empty values before hitting submit
    if(this.state.firstName.length>0 && this.state.lastName.length>0 && this.state.email.length>0 && this.state.password.length>0){
      var payload={
        "username":this.state.username,
        "email":this.state.email,
      "password":this.state.password,
      "firstName": this.state.firstName,
      "lastName":this.state.lastName,
      
      }
      axios.post(apiBaseUrl+'/signup', payload)
     .then(function (response) {
       console.log(response);
       if(response.data.code === 200){
        //  console.log("registration successfull");
         var loginscreen=[];
         loginscreen.push(<Login parentContext={this} appContext={self.props.appContext}/>);
         var loginmessage = "Not Registered yet.Go to registration";
         self.props.parentContext.setState({loginscreen:loginscreen,
         loginmessage:loginmessage,
         buttonLabel:"Register",
         isLogin:true
          });
       }
       else{
         console.log("some error ocurred",response.data.code);
       }
     }
     )
     .catch(function (error) {
       console.log(error);
     });
    }
    else{
      alert("Input field value is missing");
  }
}
  render() {
    // console.log("props",this.props);
  //  var userhintText,userLabel;
  //  if(this.props.role === "student"){
   //   userhintText="Username";
    //  userLabel="Username";
  //  }
    // else{
    //   userhintText="Enter your Teacher Id";
    //   userLabel="Teacher Id";
    // }
    return (
      <div>
        <MuiThemeProvider>
          <div>
          <AppBar
             title="Register"
           />
           <TextField
             hintText="Enter your First Name"
             floatingLabelText="First Name"
             onChange = {(event,newValue) => this.setState({firstName:newValue})}
             />
           <br/>
           <TextField
             hintText="Enter your Last Name"
             floatingLabelText="Last Name"
             onChange = {(event,newValue) => this.setState({lastName:newValue})}
             />
           <br/>
           <TextField
             hintText="Email"
             floatingLabelText="Email"
             onChange = {(event,newValue) => this.setState({email:newValue})}
             />
           <br/>
           <TextField
             type = "password"
             hintText="Enter your Password"
             floatingLabelText="Password"
             onChange = {(event,newValue) => this.setState({password:newValue})}
             />
           <br/>
           <TextField
             hintText="Username"
             floatingLabelText="Username"
             onChange = {(event,newValue) => this.setState({username:newValue})}
             />
           <br/>
           <RaisedButton label="Submit" primary={true} style={style} onClick={this.handleClick}/>
          </div>
         </MuiThemeProvider>
      </div>
    );
  }
}

const style = {
  margin: 15,
};

export default Register;
