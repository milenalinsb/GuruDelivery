import React from 'react'
import Separator from '../Separator'

export default function ProductCard() {
  return (
    <div className='max-w-sm bg-surface rounded-lg drop-shadow-md font-sans p-3'>
        <div className='gap-5 grid grid-cols-4 '>
            <div className='col-start-1 col-end-3 row-start-1 row-end-3'>
                <img src='https://bobs.com.br/media/filer_public_thumbnails/filer_public/1f/61/1f61237f-ecaa-4cca-a3ce-c770d5974560/new_v4-bobs-burger-celeb.png__1200x630_subsampling-2_upscale.png'/>
            </div>
            <div className='col-start-2 col-end-5' >
                Name
            </div>
            <div className='col-start-2 col-end-5 text-sm' >
                asdajsodiaj sdlasdijasodi ajsdoaskdja sodiajsdkada joisdjaksodasj
            </div>
            <div className='col-start-2 col-end-5 text-end font-bold'>
                R$ XX,xx
            </div>
            <Separator className='col-start-1 col-end-5'/>
        </div>
    </div>
  )
}
