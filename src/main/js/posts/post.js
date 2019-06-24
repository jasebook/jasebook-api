import React from 'react';

const Post = (props) => {
	return (
		<div className='post-main'>
			<div className='post-content'>
				{props.post.content}
			</div>
			<div className='post-timedate'>
				{props.post.postedTime}
			</div>
		</div>
	)
}

export default Post;
