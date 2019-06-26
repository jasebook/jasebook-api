import React, { Component } from 'react';
const axios = require('axios');

class PostAdder extends Component {
    constructor(props) {
        super(props);
        this.state = {
            inputValue: ''
        };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.postUpdater = props.postUpdater;
    }

    handleSubmit(event) {
        event.preventDefault();
        axios.post("/api/posts", {
            content: this.state.inputValue
        }).then(() => {
            this.postUpdater()
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
                    <input type="text" data-cy="addPostTxtBox" value={this.state.inputValue} onChange={(event) => this.updateInputValue(event) }/>
                    <input type="submit" data-cy="submitPost" value="Post me"/>
                </form>
            </div>
        )}
}

export default PostAdder;