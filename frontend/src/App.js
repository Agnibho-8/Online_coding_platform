import React, { Component } from 'react';
import './App.css';
import LoginScreen from './Loginscreen';
import ReactDOM from 'react';
import {BrowserRouter as Router, NavLink, Route} from 'react-router-dom';
import Login from './Login';
import Register from './Register';
import HomePage from './HomePage';
import Start from './Start';
import { green100 } from 'material-ui/styles/colors';
import { red100 } from 'material-ui/styles/colors';
import solutionPage from './SolutionPage';
import ProblemsPage from './ProblemsPage';
class App extends Component {
  constructor(props){
    super(props);
    // this.state={
    //   loginPage:[],
    //   uploadScreen:[]
    // }
  }
  render(){
    return(
      <Router>
      <div className='App'>
        <h1>Online Coding Platform</h1>
     <Route exact path = "/" component={Start}/>
     <Route exact path="/login" component={LoginScreen}/>
     <Route exact path="/signup" component={Register}/>
     <Route exact path = "/home" component={HomePage}/>
     <Route exact path = "/solution" component={solutionPage}/>
     <Route exact path = "/problems" component={ProblemsPage}/>
   </div>
   </Router>
    );
  }
}

export default App;
