import React from 'react';

export const FightDetailCard = ({fight}) => {
    if (!fight) return null;
    return (
        <div className="FightDetailCard">
            <h3>Latest Fights</h3>
            <h4>Fight Details</h4>
            <h4>{fight.redFighter} vs {fight.blueFighter}</h4>

        </div>
    );
}