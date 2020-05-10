import React, { Component } from 'react';
import { green100 } from 'material-ui/styles/colors';
import { red100 } from 'material-ui/styles/colors';
import {BrowserRouter as Router, NavLink, Route} from 'react-router-dom';

class Start extends Component{
  constructor(props){
    super(props)
  }
  render(){
    return(
        <div>
          <NavLink to="/login" activeStyle={
            {color:green100}
          }>LOG IN</NavLink>
      <br></br>
          <NavLink to ="/signup" activeStyle={
            {color:red100}
          }>SIGN UP</NavLink>
        </div>
    )
  }
}

export default Start;