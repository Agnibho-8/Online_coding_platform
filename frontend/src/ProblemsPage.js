import React, { Component } from "react";
import axios from "axios";
import { Link, Redirect, NavLink } from "react-router-dom";

import "./ProblemsPage.css";

export class ProblemsPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      problemId: [],
      problemStatement: [],
      difficultyLevel: [],
      pointsAlotted: [],
      sampleInput: "",
      sampleOutput: "",
    };
  }

  componentDidMount() {
    axios
      .get("http://localhost:8080/problems/")
      .then((response) => {
        // handle success

        this.setState({
          problemId: response.data,
          problemStatement: response.data,
        });

        console.log(response.data);
      })
      .catch(function (error) {
        // handle error
        console.log(error);
      });
  }
  onClick = (event) => {
    this.state.x = event.currentTarget.textContent;

    console.log(this.state.x);
  };
  Shodata = () => {
    var data = this.state.problemId.map((problem) => {
      return (
        <div className="problems32">
          <NavLink
            to={{
              pathname: "/solution",
              state: { problemID: problem.problemId },
            }}
          >
            <div onClick={this.onClick}>
              <h3 className="statement">{problem.problemStatement}</h3>
              <div>
                <span className="diffLevel">{problem.difficultyLevel}</span>,
                Maximum points:{" "}
                <span className="score">{problem.pointsAlotted}</span>
              </div>
            </div>
          </NavLink>
        </div>
      );
    });
    return data;
  };

  render() {
    var data = this.Shodata();
    return (
      <div className="problemsContainer">
        <div>{data}</div>
      </div>
    );
  }
}

export default ProblemsPage;
