import React from 'react';
import {Link} from 'react-router-dom';

import './FightSmallCard.scss';

export const FightSmallCard = ({fighterName, fight}) => {
    if (!fight) return null;
    const otherFighter = fight.redFighter === fighterName ? fight.blueFighter : fight.redFighter;
    const otherFighterRoute = "/fighters/" + otherFighter;
    const winner = fight.winner === "Blue" ? fight.blueFighter : fight.redFighter;
    const isWinner = fighterName === winner;
    const result = fighterName === winner ? "won" : "lost";
    return (
        <div className={isWinner ? 'FightSmallCard won-card' : 'FightSmallCard lost-card'}>
            <span className="vs">vs</span>
            <h2><Link to={otherFighterRoute}>{otherFighter}</Link></h2>
            <p className="fight-result">{result} by {fight.finish}</p>

        </div>
    );
}