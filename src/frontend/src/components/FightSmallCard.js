import React from 'react';
import { Link } from 'react-router-dom';
export const FightSmallCard = ({fighterName, fight}) => {
    if (!fight) return null;
    const otherFighter = fight.redFighter === fighterName ? fight.blueFighter : fight.redFighter;
    const otherFighterRoute = "/fighters/" + otherFighter;
    const winner = fight.winner === "Blue" ? fight.blueFighter : fight.redFighter;
    const result = fighterName === winner ? "won" : "lost";
    return (
        <div className="FightSmallCard">
            <h3>vs <Link to={otherFighterRoute}>{otherFighter}</Link></h3>
            <p>{result} by {fight.finish}</p>

        </div>
    );
}