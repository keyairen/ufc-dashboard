import React from 'react';
import {Link} from 'react-router-dom';

import './EventTile.scss';

export const EventTile = ({eventName}) => {

    return (
        <div className="EventTile">
            <h1>
                <Link to={`/events/${eventName}`}>{eventName}</Link>
            </h1>
        </div>
    );
}