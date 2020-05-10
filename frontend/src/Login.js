import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import DropDownMenu from 'material-ui/DropDownMenu';
import MenuItem from 'material-ui/MenuItem';
var apiBaseUrl = "http://localhost:8080";
import axios from 'axios';
import HomePage from './HomePage';
import {Redirect} from 'react-router-dom';
class Login extends Component {
  constructor(props){
    super(props);
    var localloginComponent=[];
    localloginComponent.push(
      <MuiThemeProvider key={"theme"}>
        <div>
         <TextField
           hintText="Username"
           floatingLabelText="Username"
           onChange={(event,newValue) => this.setState({username:newValue})}
           />
         <br/>
           <TextField
             type="password"
             hintText="Enter your Password"
             floatingLabelText="Password"
             onChange = {(event,newValue) => this.setState({password:newValue})}
             />
           <br/>
           <RaisedButton label="Submit" primary={true} style={style} onClick={(event) => this.handleClick(event)}/>
       </div>
       </MuiThemeProvider>
    )
    this.state={
      isLoggedIn : false,
      username:'',
      password:'',
      // menuValue:1,
       loginComponent:localloginComponent,
      // loginRole:'student'
    }
  }
  handleClick(event){
    var self = this;
    var payload={
      "username":this.state.username,
	    "password":this.state.password,
    }
    axios.post(apiBaseUrl+'/login', payload)
   .then((response)=>{{
     console.log(response);
     if(response.data == 'yes'){
      this.setState({
        isLoggedIn : true
      })
      alert("Login successfull")
       console.log("Login successfull");
     }
     else{
       this.setState({
         isLoggedIn : false
       })
       console.log("incorrect username or password");
       alert("incorrect username or password");
     }
   }})
   .catch(function (error) {
     console.log(error);
   });
  }
  handleMenuChange(value){
    console.log("menuvalue",value);
    var loginRole;
 //   if(value==1){
      var localloginComponent=[];
      localloginComponent.push(
        <MuiThemeProvider>
          <div>
           <TextField
             hintText="Username"
             floatingLabelText="Username"
             onChange = {(event,newValue) => this.setState({username:newValue})}
             />
           <br/>
             <TextField
               type="password"
               hintText="Enter your Password"
               floatingLabelText="Password"
               onChange = {(event,newValue) => this.setState({password:newValue})}
               />
             <br/>
             <RaisedButton label="Submit" primary={true} style={style} onClick={ this.handleClick}/>
         </div>
         </MuiThemeProvider>
      )
    this.setState({menuValue:value,
                   loginComponent:localloginComponent,
                  })
  }
  render() {
    return (
      <div>
        <MuiThemeProvider>
        <AppBar
             title="Login"
           />
        </MuiThemeProvider>
     {this.state.isLoggedIn ? (<Redirect to="/home"/>):this.state.loginComponent}
      </div>
    );
  }
}

const style = {
  margin: 15,
};

export default Login;
