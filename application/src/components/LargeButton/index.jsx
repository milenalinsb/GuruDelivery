import React from 'react'

export default function LargeButton({text, action, bg, ...props}) {
  return (
    <button className=
      {bg?'bg-primary h-16 rounded text-on-primary font-bold font-sans':
          'bg-background h-16 rounded text-primary font-bold font-sans border'} type='submit'  {...props}
      onClick={action}
    >
        {text}
    </button>
  )
}
