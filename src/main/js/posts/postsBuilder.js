import React from 'react';
import Posts from './posts';
import PostAdder from './postAdder';
const axios = require('axios');


class PostsBuilder extends React.Component {
    constructor(props) {
        super(props);
        this.state = {posts: []};
    }

    componentDidMount() {
        axios.get('/api/posts').then(response => {
            console.log(response);
            this.setState({posts: response.data._embedded.posts});
        });
    }

    render() {
        return (
            <div>
                <Posts posts={this.state.posts}/>
                <PostAdder/>
            </div>

        )
    }
}

export default PostsBuilder;
