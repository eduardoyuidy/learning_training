import React, { Component } from 'react';
import { Link, hashHistory } from 'react-router';
import { graphql } from 'react-apollo';

import fetchSongQuery from '../queries/fetchSong';
import LyricCreate from './LyricCreate';

class SongDetail extends Component {
  
  render () {

    const { loading, song } = this.props.data;

    if (loading) {
      return <div>Loading...</div>;
    }
    
    return (
      <div>
        <Link to="/">Back</Link>
        <h3>{ song.title }</h3>
        <LyricCreate songId={ this.props.params.id } />
      </div>
    );
  };
}

// Used the operationOptions to return a variables object to be used on the 'fetchSongQuery' based on the parameters passed from the URL path: 'songs/:id'
export default graphql(fetchSongQuery,{
  options: (props) => { return { variables: { id: props.params.id } } }
})(SongDetail);