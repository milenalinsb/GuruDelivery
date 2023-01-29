import React from 'react'
import style from './InputText.module.css'

export default function InputText({...props}) {
  return (
    <input className={style.input} {...props}/>
  )
}
