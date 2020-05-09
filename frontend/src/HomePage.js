import React from 'react';

function HomepageImage() {
  const url = 'https://www.shutterstock.com/image-vector/online-learning-programming-coding-on-different-1378143746';
  return (
    <img src={url} style={{width: 650}} alt='Image of Golden Gate Bridge' />
  );
}

export default HomepageImage;