import React from 'react'

export default function Counter({value, onChange}) {

    function onPlus(){
        onChange(value+1)
    }

    function onMinus(){
        if(value>0)
            onChange(value-1)
    }

  return (
    <div className='flex'>
        <button className='bg-primary px-3 py-1 text-on-primary font-bold rounded-l-md'
            onClick={onMinus}
        >-</button>
            <span className='px-3 py-1'>{value}</span>
        <button className='bg-primary px-3 py-1 text-on-primary font-bold rounded-r-md'
            onClick={onPlus}
        >+</button>
    </div>
  )
}
