import React from 'react';
import {useParams} from 'react-router-dom';
import {useEffect, useState} from 'react';
import {FightDetailCardEvent} from "../components/FightDetailCardEvent";


import './EventPage.scss';


export const EventPage = () => {


    const [event, setEvent] = useState({eventFights: []});
    const {eventName} = useParams();

    useEffect(() => {
            const fetchEvent = async () => {
                const response = await fetch(`http://localhost:8080/events/${eventName}`);
                const data = await response.json();
                setEvent(data);

            };
            fetchEvent();
        }, [eventName]
    );

    return (
        <div className="EventPage">
            <div className="event-header-section">
                <h1>{eventName}</h1>
                <h2>{event.eventDate}</h2>
                <h2>{event.eventLocation}</h2>
            </div>
            {event.eventFights.map(fight => <FightDetailCardEvent key={fight.id} fight={fight}/>)}
        </div>
    );
}