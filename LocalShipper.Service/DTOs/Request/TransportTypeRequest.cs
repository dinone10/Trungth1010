﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocalShipper.Service.DTOs.Request
{
    public class TransportTypeRequest
    {
        public int Id { get; set; }
        public string TransportType1 { get; set; }
        public DateTime? CreateAt { get; set; }
    }
}
