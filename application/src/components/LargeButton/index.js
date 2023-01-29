import React from 'react'
import './style.css'

export default function LargeButton({text, action, bg}) {
  return (
    <button className='large-button' type='submit' style={!bg?{
        backgroundColor: 'var(--surfice)',
        color: 'var(--primary)',
        border: '1px solid'
        }:{}}>
        {text}
    </button>
  )
}
