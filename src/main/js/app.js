const React = require('react');
const ReactDOM = require('react-dom');
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

import PostsBuilder from './posts/postsBuilder'

const Test = () => {
    return (
        <div>
            Hello!
        </div>
    )
}

class App extends React.Component {

  render() {
    return (
        <Router>
            <nav>
                <ul>
                    <li>
                        <Link to="/">Test</Link>
                    </li>
                    <li>
                        <Link to="/posts">Post</Link>
                    </li>
                </ul>
            </nav>
            <Route path="/" exact component={Test} />
            <Route path="/posts" exact component={PostsBuilder} />
        </Router>
    )
  }
}

ReactDOM.render(
	<App />,
	document.getElementById('app')
);
