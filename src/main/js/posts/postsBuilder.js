import React from 'react';
import Posts from './posts';
import PostAdder from './postAdder';
const axios = require('axios');


class PostsBuilder extends React.Component {
    constructor(props) {
        super(props);
        this.state = {posts: []};
        this.updatePosts = this.updatePosts.bind(this);
    }

    componentDidMount() {
        this.updatePosts();
    }

    updatePosts() {
        axios.get('/api/posts/search/findAllOrderByPostedTimeDesc').then(response => {
            this.setState({posts: response.data._embedded.posts});
        });
    }

    render() {
        return (
            <div>
                <PostAdder postUpdater={this.updatePosts}/>
                <Posts posts={this.state.posts}/>
            </div>

        )
    }
}

export default PostsBuilder;
