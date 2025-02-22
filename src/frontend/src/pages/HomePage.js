import React from 'react';
import {useEffect, useState} from 'react';
import {EventTile} from "../components/EventTile";

import './HomePage.scss';


export const HomePage = () => {


    const [events, setEvents] = useState([]);

    useEffect(() => {
            const fetchEvents = async () => {
                const response = await fetch(`http://localhost:8080/events`);
                const data = await response.json();
                setEvents(data);

            };
            fetchEvents();

        }, []
    );


    return (
        <div className="HomePage">
            <div className="header-section">
                <h1 className="app-name">UFC Dashboard</h1>
            </div>
            <div className="event-grid">
                {events.map(event => <EventTile eventName={event.eventName}/>)}
            </div>
        </div>
    );
}