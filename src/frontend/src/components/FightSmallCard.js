import React from 'react';

export const FightSmallCard = ({fight}) => {
    return (
        <div className="FightSmallCard">
            <p>{fight.redFighter} vs {fight.blueFighter}</p>

        </div>
    );
}