import React from 'react';
import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import {FightDetailCard} from "../components/FightDetailCard";
import {FightSmallCard} from "../components/FightSmallCard";

export const FightPage = () => {


    const [fights, setFights] = useState([]);
    const { fighterName, year } = useParams();

    useEffect(() => {
        const fetchFights = async () => {
            const response = await fetch(`http://localhost:8080/fighter/${fighterName}/fights?year=${year}`);
            const data = await response.json();
            setFights(data);

        };
        fetchFights();

    }, []
    );


    return (
        <div className="FightPage">
            <h1>Fight Page</h1>
            {
                fights.map(fight => <FightDetailCard fighterName={fighterName} fight={fight} />)
            }
        </div>
    );
}