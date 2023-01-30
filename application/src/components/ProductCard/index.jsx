import React, { useState } from 'react'
import Counter from '../Counter'
import Separator from '../Separator'

export default function ProductCard() {

    const [counter, setCounter] = useState(0)

  return (
    <div className='max-w-sm bg-surface rounded-lg drop-shadow-md font-sans p-3'>
        <div className='flex flex-col items-center'>
            <div className=''>
                <img src='https://bobs.com.br/media/filer_public_thumbnails/filer_public/1f/61/1f61237f-ecaa-4cca-a3ce-c770d5974560/new_v4-bobs-burger-celeb.png__1200x630_subsampling-2_upscale.png'/>
            </div>
            <div className='text-lg' >
                Name
            </div>
            <div className='text-sm mb-2' >
                asdajsodiaj sdlasdijasodi ajsdoaskdja sodiajsdkada joisdjaksodasj
            </div>
            <div className='text-xl font-bold text-primary self-start'>
                R$ XX,xx
            </div>
            <hr className='w-full mb-2'/>
        </div>
        <div className='flex flex-col sm:flex-row justify-between mt-2'>
                <Counter value={counter} onChange={setCounter}/>
                <button className='bg-primary basis-2/4 py-1 rounded-md'>Adicionar</button>
        </div>
    </div>
  )
}
