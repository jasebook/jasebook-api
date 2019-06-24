import React, { Component } from 'react';
const axios = require('axios');

class PostAdder extends Component {
    constructor(props) {
        super(props);
        this.state = {
            inputValue: ''
        };
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        axios.post("/api/posts", {
            content: this.state.inputValue
        });
    }

    updateInputValue(event) {
        this.setState({
            inputValue: event.target.value
        });
    }

    render(){
        return (
            <div>
                <form id='add_post' onSubmit={this.handleSubmit}>
                    <input type="text" value={this.state.inputValue} onChange={(event) => this.updateInputValue(event) }/>
                    <input type="submit" value="Post me"/>
                </form>
            </div>
        )}
}

export default PostAdder;