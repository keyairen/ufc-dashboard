import React from 'react';
import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import {FightDetailCard} from "../components/FightDetailCard";
import {FightSmallCard} from "../components/FightSmallCard";

export const FighterPage = () => {

    const [fighter, setFighter] = useState({fights: []});
    const { fighterName } = useParams();
    useEffect(
        () => {
            const fetchFights = async () => {
                const response = await fetch(`http://localhost:8080/fighter/${fighterName}`);
                const data = await response.json();
                setFighter(data);

            };
            fetchFights();



        }, [fighterName]
    );

    if (!fighter || !fighter.fighterName) {
        return <h1>Fighter not found</h1>
    }

    return (
        <div className="FighterPage">
            <h1>{fighter.fighterName}</h1>
            <FightDetailCard fighterName={fighter.fighterName} fight={fighter.fights[0]}/>
            {fighter.fights.slice(1).map(fight => <FightSmallCard fighterName={fighter.fighterName} fight={fight} />)}
        </div>
    );
}