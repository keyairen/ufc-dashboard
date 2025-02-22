import React from 'react';
import {useParams, Link} from 'react-router-dom';
import {useEffect, useState} from 'react';
import {FightDetailCard} from "../components/FightDetailCard";
import {FightSmallCard} from "../components/FightSmallCard";

import './FighterPage.scss';


export const FighterPage = () => {

    const [fighter, setFighter] = useState({fights: []});
    const {fighterName} = useParams();
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
            <div className="fighter-name-section">
                <h1 className="fighter-name">{fighter.fighterName}</h1>
            </div>
            <div className="win-loss-section">
                <h3>Wins / Losses</h3>
                <div className="win-loss-text">
                    <h4 className="wins">{fighter.totalWins}</h4>
                    <h4 className="losses">{fighter.totalLosses}</h4>
                </div>
            </div>
            <div className="fight-detail-section">
                <h3>Latest Fights</h3>
                <FightDetailCard fighterName={fighter.fighterName} fight={fighter.fights[0]}/>
            </div>
            {fighter.fights.slice(1).map(fight => <FightSmallCard fighterName={fighter.fighterName} fight={fight}/>)}
            <div className="more-link">
                <Link to={`/fighters/${fighterName}/fights/${fighter.fights[0].date.slice(0,4)}`}>More ></Link>
            </div>
        </div>
    );
}