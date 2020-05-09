import React, { Component } from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import DropDownMenu from 'material-ui/DropDownMenu';
import MenuItem from 'material-ui/MenuItem';
var apiBaseUrl = "http://localhost:8080";
import axios from 'axios';
import HomePage from './HomePage'
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
  // componentWillMount(){
  // // console.log("willmount prop values",this.props);
  // if(this.props.role != undefined){
  //   if(this.props.role == 'student'){
  //     console.log("in student componentWillMount");
  //     var localloginComponent=[];
  //     localloginComponent.push(
  //       <MuiThemeProvider>
  //         <div>
  //          <TextField
  //            hintText="Enter your College Rollno"
  //            floatingLabelText="Student Id"
  //            onChange = {(event,newValue) => this.setState({username:newValue})}
  //            />
  //          <br/>
  //            <TextField
  //              type="password"
  //              hintText="Enter your Password"
  //              floatingLabelText="Password"
  //              onChange = {(event,newValue) => this.setState({password:newValue})}
  //              />
  //            <br/>
  //            <RaisedButton label="Submit" primary={true} style={style} onClick={(event) => this.handleClick(event)}/>
  //        </div>
  //        </MuiThemeProvider>
  //     )
  //     this.setState({menuValue:1,loginComponent:localloginComponent,loginRole:'student'})
  //   }
  //   else if(this.props.role == 'teacher'){
  //     console.log("in teacher componentWillMount");
  //     var localloginComponent=[];
  //     localloginComponent.push(
  //       <MuiThemeProvider>
  //         <div>
  //          <TextField
  //            hintText="Enter your College Rollno"
  //            floatingLabelText="Teacher Id"
  //            onChange={(event,newValue) => this.setState({username:newValue})}
  //            />
  //          <br/>
  //            <TextField
  //              type="password"
  //              hintText="Enter your Password"
  //              floatingLabelText="Password"
  //              onChange={(event,newValue) => this.setState({password:newValue})}
  //              />
  //            <br/>
  //            <RaisedButton label="Submit" primary={true} style={style} onClick={(event) => this.handleClick(event)}/>
  //        </div>
  //        </MuiThemeProvider>
  //     )
  //     this.setState({menuValue:2,loginComponent:localloginComponent,loginRole:'teacher'})
  //   }
  // }
  // }
  handleClick(event){
    var self = this;
    var payload={
      "username":this.state.username,
	    "password":this.state.password,
    }
    axios.post(apiBaseUrl+'/login', payload)
   .then(function (response) {
     console.log(response);
     if(response.data == 'yes'){
      this.setState({
        isLoggedIn : true
      })


       console.log("Login successfull");
      //  var uploadScreen=[];
      //  uploadScreen.push(<UploadPage appContext={self.props.appContext}/>)
      //  self.props.appContext.setState({loginPage:[],uploadScreen:uploadScreen})
     }
    //  else if(response.data.code == 204){
    //    console.log("Username password do not match");
    //    alert(response.data.success)
    //  }
     else{
       this.setState({
         isLoggedIn : false
       })
       console.log("incorrect username or password");
       alert("incorrect username or password");
     }
   })
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
 //   }
    // else if(value == 2){
    //   var localloginComponent=[];
    //   loginRole='teacher';
    //   localloginComponent.push(
    //     <MuiThemeProvider>
    //       <div>
    //        <TextField
    //          hintText="Enter your College Rollno"
    //          floatingLabelText="Teacher Id"
    //          onChange = {(event,newValue) => this.setState({username:newValue})}
    //          />
    //        <br/>
    //          <TextField
    //            type="password"
    //            hintText="Enter your Password"
    //            floatingLabelText="Password"
    //            onChange = {(event,newValue) => this.setState({password:newValue})}
    //            />
    //          <br/>
    //          <RaisedButton label="Submit" primary={true} style={style} onClick={(event) => this.handleClick(event)}/>
    //      </div>
    //      </MuiThemeProvider>
    //   )
    // }
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
        {/* <MuiThemeProvider>
        <div>
        <p>Login as:</p>
        <DropDownMenu value={this.state.menuValue} onChange={(event,index,value)=>this.handleMenuChange(value)}>
          <MenuItem value={1} primaryText="Student" />
          <MenuItem value={2} primaryText="Teacher" />
        </DropDownMenu>
        </div>
        </MuiThemeProvider> */}
        {this.state.isLoggedIn ? <HomePage/>:this.state.loginComponent}
      </div>
    );
  }
}

const style = {
  margin: 15,
};

export default Login;
