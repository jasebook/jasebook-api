const React = require('react');
const ReactDOM = require('react-dom');
import {BrowserRouter, Route, Link, Switch} from "react-router-dom";
import auth from './auth';
import {ProtectedRoute} from "./protected.route";
import {useState} from 'react';
const axios = require('axios');


import PostsBuilder from './posts/postsBuilder'

const Login = (props) => {
    const [userName, setUserName] = useState('');
    const [password, setPassword] = useState('');
    return (
        <div>
            <h1>Login</h1>
            <form>
                Username: <input type="text" value={userName} onChange={e => setUserName(e.target.value)}/>
                Password: <input type="text" value={password} onChange={e => setPassword(e.target.value)}/>
            </form>
            <button onClick={
                () => {
                    props.handleLogin(userName, password);
                    auth.login();
                }
            }>Log in
            </button>
        </div>
    )
};

const AppLayout = (props) => {
    return (
        <div>
            <h1>App Layout</h1>
            <button onClick={() => {
                auth.logout(() => {
                    props.history.push("/");
                })
            }}>Logout
            </button>
        </div>
    )
};

class App extends React.Component {
    constructor(props) {
        super(props);
        this.setCredentials = this.setCredentials.bind(this);
        this.myLogin = this.myLogin.bind(this);
    }

    setCredentials(username, password) {
        localStorage.setItem('myUsername', username);
        localStorage.setItem('myPassword', password);
    };

    myLogin(props) {
        return (
            <Login
                handleLogin={this.setCredentials.bind(this)}
            />
        )
    };

    render() {
        return (
            <BrowserRouter>
                <h1>Acebook</h1>
                <nav>
                    <ul>
                        <li><Link to={"/"}>Log in</Link></li>
                        <li><Link to={"/app"}>App</Link></li>
                        <li><Link to={"/posts"}>Posts</Link></li>
                    </ul>
                </nav>
                <Switch>
                    <Route exact path="/" component={this.myLogin}/>
                    <ProtectedRoute exact path="/posts" component={PostsBuilder}/>
                    <ProtectedRoute exact path="/app" component={AppLayout}/>
                    <Route path="*" component={() => "404 not found"}/>
                </Switch>
            </BrowserRouter>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('app')
);

axios.interceptors.request.use(
    config => {
        console.log('in interceptor');
        let userName = localStorage.getItem('myUsername');
        let password = localStorage.getItem('myPassword');
        let token = "Basic " + btoa(userName + ":" + password);
        config.headers.authorization = token;
        return config;
    },
    error => Promise.reject(error)
);
