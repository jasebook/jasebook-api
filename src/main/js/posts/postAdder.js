import React from 'react';

const client = require('../client');

const PostAdder = () => {
    return (
        <div>
            <form id='add_post'>
                <input type="text" name="new_post"/>
                <input type="submit" value="Post me"/>
            </form>
        </div>
)
}
export default PostAdder;