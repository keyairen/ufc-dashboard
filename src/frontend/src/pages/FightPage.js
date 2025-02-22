import React from 'react';
import {useParams} from 'react-router-dom';
import {useEffect, useState} from 'react';
import {FightDetailCard} from "../components/FightDetailCard";

import './FightPage.scss';
import {YearSelector} from "../components/YearSelector";

export const FightPage = () => {


    const [fights, setFights] = useState([]);
    const {fighterName, year} = useParams();

    useEffect(() => {
            const fetchFights = async () => {
                const response = await fetch(`http://localhost:8080/fighter/${fighterName}/fights?year=${year}`);
                const data = await response.json();
                setFights(data);

            };
            fetchFights();

        }, [fighterName, year]
    );


    return (
        <div className="FightPage">
            <div className="year-selector">
                <h3>Select Year</h3>
                <YearSelector fighterName={fighterName}/>
            </div>
            <div>
                <h1>{fighterName} fights in {year}</h1>
                {fights.map(fight => <FightDetailCard key={fight.id} fighterName={fighterName} fight={fight}/>)}
            </div>
        </div>
    );
}