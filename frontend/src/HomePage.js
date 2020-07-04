import React, { Component } from "react";
import { Redirect, Link } from "react-router-dom";
class HomePage extends Component {
  constructor(props) {
    super(props);
  }
  /*routeChange = () => {
    alert("clicked function");
    <Redirect to="/problems" />;
  };*/
  render() {
    return (
      <div>
        <h1>HOME</h1>
        <img src="https://cdn1.vectorstock.com/i/1000x1000/85/30/coding-neon-sign-pc-monitor-with-programming-neon-vector-22428530.jpg" />
        <span className="input-group-btn">
          <Link to="/problems">Problems</Link>
        </span>
      </div>
    );
  }
}

export default HomePage;
