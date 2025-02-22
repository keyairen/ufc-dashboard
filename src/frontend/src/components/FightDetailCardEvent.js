import React from 'react';
import { Link } from "react-router-dom";

import './FightDetailCardEvent.scss';

export const FightDetailCardEvent = ({fight}) => {
    if (!fight) return null;

    const redFighter = fight.redFighter;
    const blueFighter = fight.blueFighter
    const winner = fight.winner === "Blue" ? fight.blueFighter : fight.redFighter;
    const finishDetails = fight.finishDetails === "" ? "" : "("+fight.finishDetails+")";
    const titleBout = fight.titleBout === true ? "Yes" : "No";

    return (
        <div className="FightDetailCardEvent">
            <div>
                <h1 className="fighter-name"><Link to={`../fighters/${redFighter}`}>{redFighter}</Link></h1>
                <span className="vs">vs</span>
                <h1 className="fighter-name"><Link to={`../fighters/${blueFighter}`}>{blueFighter}</Link></h1>
                <h3 className="fight-result">{winner} by {fight.finish} {finishDetails}</h3>
            </div>
            <div className="additional-detail">
                <h3>Weight Class</h3>
                <p>{fight.weightClass}</p>
                <h3>Title Bout</h3>
                <p>{titleBout}</p>
                <h3># of Rounds</h3>
                <p>{fight.numberOfRounds}</p>
            </div>
        </div>
    );
}