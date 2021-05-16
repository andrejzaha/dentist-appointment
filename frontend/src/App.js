import React, {
    Component
} from "react";

import { hot } from 'react-hot-loader';

import {
    Route,
    Redirect,
    Switch,
    BrowserRouter as Router
} from "react-router-dom";

import ReasonChoicePage from "./pages/reason-choice-page/reason-choice-page";

import Table from "./components/Table";

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
            <Route exact path="/view" component={Table} />
            <Route exact path="/reason-choice" component={ReasonChoicePage} />

            <Redirect from='/' to='/reason-choice'/>
        </Switch>
      </Router>
    );
  }
}

export default hot(module)(App);
