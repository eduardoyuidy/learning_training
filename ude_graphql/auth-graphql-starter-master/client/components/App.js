import React from 'react';

import Header from './Header';

const App = (props) => {

  return (
    <div>
      <Header />
      {props.chidren}
    </div>
  )
}

export default App;
