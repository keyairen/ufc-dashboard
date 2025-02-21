import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import { FighterPage } from "./pages/FighterPage";
import {FightPage} from "./pages/FightPage";

function App() {
    return (
        <div className="App">
            <Router>
                <Routes>
                    <Route path="/fighters/:fighterName" element={<FighterPage/>} />
                    <Route path="/fighters/:fighterName/fights/:year" element={<FightPage/>} />
                </Routes>
            </Router>
        </div>
    );
}

export default App;
