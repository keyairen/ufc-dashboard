import React from 'react';
import {Link} from 'react-router-dom';

import './YearSelector.scss';

export const YearSelector = ({fighterName}) => {

    let years = [];
    const startYear = process.env.REACT_APP_DATA_START_YEAR;
    const endYear = process.env.REACT_APP_DATA_END_YEAR;

    for (let i = startYear; i <= endYear; i++) {
        years.push(i);
    }

    return (
        <ol className="YearSelector">
            {years.map(year => (
                <li key={year}>
                    <Link to={`/fighters/${fighterName}/fights/${year}`}>{year}</Link>
                </li>
            ))}
        </ol>
    )
}
