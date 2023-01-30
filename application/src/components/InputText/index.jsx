import React from 'react'


export default function InputText({className, ...props}) {
    let classes
    if(className){
      classes = 'bg-background h-12 p-5 my-1 min-w-0 w-full '+ className
    }else{
      classes = 'bg-background h-12 p-5 my-1 min-w-0 w-full '
    }
  return (
    <input className={classes} {...props}/>
  )
}
