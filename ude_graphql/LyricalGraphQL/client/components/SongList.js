import React , { Component } from 'react';
import { Link }  from 'react-router';
import gql from 'graphql-tag';
import { graphql } from 'react-apollo';

import query from '../queries/fetchSongs';
import mutation from '../mutations/deleteSong';

class SongList extends Component {

  onSongDelete(id) {
    this.props.mutate({ 
      variables: { id }
      }).then(() => {
        // Here we use this approach (this.props.data.refetch()) instead of the 'refetchQueries' because here we just wants to query the queries associated with this 'SongList' component.
        this.props.data.refetch();
      })
  };

  renderSongs() {
    return this.props.data.songs.map(({ id, title }) => {
      return (
        <li key={id} className="collection-item">
          <Link to={`/songs/${id}`}>{title}</Link>
          
          <i 
            className="material-icons"
            onClick={() => this.onSongDelete(id)}
          >
            delete
          </i>
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
 
// Associate the Query with our component using 'react-apollo', also here we are adding the mutation
export default graphql(mutation)(
  graphql(query)(SongList)
);
