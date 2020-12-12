import React, { Component } from "react";
import { Route, BrowserRouter as Router } from "react-router-dom";
import Table from "./components/Table";

class App extends Component {
  render() {
    return (
      <Router>
        <Route exact path="/view" component={Table} />
      </Router>
    );
  }
}

export default App;
