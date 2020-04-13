import React , { Component } from 'react';
import { Link }  from 'react-router';
import gql from 'graphql-tag';
import { graphql } from 'react-apollo';
import query from '../queries/fetchSongs';

class SongList extends Component {

  renderSongs() {
    return this.props.data.songs.map(song => {
      return (
        <li key={song.id} className="collection-item">
          {song.title}
        </li>
      );
    });
  };

  render() {

    if (this.props.data.loading) { 
      return (<div>Loading...</div>);
    }

    return (
      <div>
        <ul className="collection">
          {this.renderSongs()}
        </ul>
        <Link
          to="/songs/new"
          className="btn-floating btn-large red right"
        >
          <i className="material-icons">add_circle_outline</i>
        </Link>        
      </div>
    );
  }
}
 
// Associate the Query with our component using 'react-apollo'
export default graphql(query)(SongList);
