import React from 'react';
import { useEffect, useState } from 'react';
import {FightDetailCard} from "../components/FightDetailCard";
import {FightSmallCard} from "../components/FightSmallCard";

export const FighterPage = () => {

    const [fighter, setFighter] = useState({fights: []});

    useEffect(
        () => {
            const fetchFights = async () => {
                const response = await fetch('http://localhost:8080/fighter/Islam%20Makhachev');
                const data = await response.json();
                setFighter(data);

            };
            fetchFights();



        }, []
    );

    return (
        <div className="FighterPage">
            <h1>{fighter.fighterName}</h1>
            <FightDetailCard fight={fighter.fights[0]}/>
            {fighter.fights.slice(1).map(fight => <FightSmallCard fight={fight} />)}
        </div>
    );
}