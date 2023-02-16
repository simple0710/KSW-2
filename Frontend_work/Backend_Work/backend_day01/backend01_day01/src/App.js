import './App.css';

import { useDispatch, useSelector } from 'react-redux';
import StateView from './StateView';
import StateController from './StateController';

function App() {

    return (
        <div className="App">
        <h1>Hello world</h1>
        <StateView />
        <StateController />
        </div>
    );
}

export default App;
