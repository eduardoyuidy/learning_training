import React, { Component } from 'react';
import { graphql } from 'react-apollo';
import gql from 'graphql-tag';

class LyricList extends Component {

  onLike(lyricId, likes) {

    this.props.mutate({ 
      variables: { id: lyricId },
      optimisticResponse: {
        __typename: 'Mutation',
        likeLyric: {
          id: lyricId,
          __typename: 'LyricType',
          likes: likes + 1,
        }
      }
    });
  }

  renderLyrics() {
    return this.props.lyrics.map(({ id, content, likes }) => {
      return (
        <li key={id} className="collection-item">
          {content}
          <div className="vote-box">
            {likes}
            <i className="material-icons"
              onClick={() => this.onLike(id, likes)}
            >thumb_up
            </i>
          </div>
        </li>
      );
    })    
  }

  render() {
    return (
      <ul className="collection">
        {this.renderLyrics()}
      </ul>
    );
  }
};

const mutation = gql`
  mutation LikeLyric ($id: ID!) {
    likeLyric (id: $id) {
      id
      content
      likes
    }
  }
`;

export default graphql(mutation)(LyricList);