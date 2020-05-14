import React, { Component } from 'react';
import axios from 'axios';

export class ProblemsPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            problemId:5,
            problemStatement:'',
            difficultyLevel:'',
            pointsAlotted:'',
            sampleInput:'',
            sampleOutput:''
        }
    };

    componentDidMount() {
        axios.get('http://localhost:8080/problems')
            .then( (response)=> {
                // handle success

                this.setState({
                    problemId: response.data[0].problemId,
            problemStatement:response.data[0].problemStatement,
            difficultyLevel:response.data[0].difficultyLevel,
            pointsAlotted:response.data[0].pointsAlotted,
            sampleInput:response.data[0].sampleInput,
            sampleOutput:response.data[0].sampleOutput
                })
                console.log(response);
            })
            .catch(function (error) {
                // handle error
                console.log(error);
            })
    }
    render() {
        return (
            <div>
                
        <h1>{this.state.problemId}</h1>
        <div>{this.state.problemStatement}</div>
            </div>
        )
    }
}

export default ProblemsPage
