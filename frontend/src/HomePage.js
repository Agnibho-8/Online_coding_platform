import React, { Component } from "react";
import { Redirect, Link } from "react-router-dom";

import "./HomePage.css";

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
      <div className="homeContainer">
        <div className="cover">
          <p className="homeHeader">Practice makes you perfect!</p>
          {/* for changing problems button */}
          <span className="input-group-btn problemList">
            <Link to="/problems">Problems</Link>
          </span>
        </div>
      </div>
    );
  }
}

export default HomePage;
