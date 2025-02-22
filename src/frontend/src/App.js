import logo from './logo.svg';
import './App.scss';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import { FighterPage } from "./pages/FighterPage";
import {FightPage} from "./pages/FightPage";
import { HomePage } from "./pages/HomePage";
import {EventPage} from "./pages/EventPage";

function App() {
    return (
        <div className="App">
            <Router>
                <Routes>
                    <Route path="/fighters/:fighterName" element={<FighterPage/>} />
                    <Route path="/fighters/:fighterName/fights/:year" element={<FightPage/>} />
                    <Route path="/events/:eventName" element={<EventPage />} />
                    <Route path="/home" element={<HomePage/>} />
                </Routes>
            </Router>
        </div>
    );
}

export default App;
