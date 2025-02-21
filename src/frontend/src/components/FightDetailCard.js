import React from 'react';
import { Link } from "react-router-dom";

export const FightDetailCard = ({fighterName, fight}) => {
    if (!fight) return null;
    const otherFighter = fight.redFighter === fighterName ? fight.blueFighter : fight.redFighter;
    const otherFighterRoute = "/fighters/" + otherFighter;
    const winner = fight.winner === "Blue" ? fight.blueFighter : fight.redFighter;
    const result = fighterName === winner ? "won" : "lost";
    const finishDetails = fight.finishDetails === "" ? "" : "("+fight.finishDetails+")";
    return (
        <div className="FightDetailCard">
            <h3>Latest Fights</h3>
            <h1>vs <Link to={otherFighterRoute}>{otherFighter}</Link></h1>
            <h2>{fight.eventName}</h2>
            <h2>{fight.date}</h2>
            <h3>at {fight.location}</h3>
            <h3>{result} by {fight.finish} {finishDetails}</h3>
        </div>
    );
}