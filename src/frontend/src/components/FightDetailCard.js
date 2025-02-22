import React from 'react';
import {Link} from "react-router-dom";

import './FightDetailCard.scss';

export const FightDetailCard = ({fighterName, fight}) => {
    if (!fight) return null;
    const otherFighter = fight.redFighter === fighterName ? fight.blueFighter : fight.redFighter;
    const otherFighterRoute = "/fighters/" + otherFighter;
    const eventRoute = "/events/" + fight.eventName;
    const winner = fight.winner === "Blue" ? fight.blueFighter : fight.redFighter;
    const isWinner = fighterName === winner;
    const result = fighterName === winner ? "won" : "lost";
    const finishDetails = fight.finishDetails === "" ? "" : "(" + fight.finishDetails + ")";
    const reachAdvantage = fight.redFighterReachCms > fight.blueFighterReachCms ? fight.blueFighter : fight.redFighter;
    const titleBout = fight.titleBout === true ? "Yes" : "No";

    return (
        <div className={isWinner ? 'FightDetailCard won-card' : 'FightDetailCard lost-card'}>
            <div>
                <h3 className="fight-date">{fight.date}</h3>
                <h2 className="fight-event-name"><Link to={eventRoute}>{fight.eventName}</Link></h2>
                <h3 className="fight-location">{fight.location}</h3>
                <span className="vs">vs</span>
                <h1 className="opponent"><Link to={otherFighterRoute}>{otherFighter}</Link></h1>
                <h3 className="fight-result">{result} by {fight.finish} {finishDetails}</h3>
            </div>
            <div className="additional-detail">
                <h3>Weight Class</h3>
                <p>{fight.weightClass}</p>
                <h3>Title Bout</h3>
                <p>{titleBout}</p>
                <h3># of Rounds</h3>
                <p>{fight.numberOfRounds}</p>
                <h3>Reach Advantage</h3>
                <p>{reachAdvantage}</p>
            </div>
        </div>
    );
}